import java.io.*;
import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// jeden zaznam v "databazi"
class Bug {
    public String title;
    public String owner;
    public Bug(String title, String owner) {
        this.title = title;
        this.owner = owner;
    }
}

public class Findbug extends HttpServlet {
    // nase jednoducha fake "databaze"
    static Map<Integer, Bug> bugs = new HashMap<Integer, Bug>();
    static {
        bugs.put(1,    new Bug("OpenJDK failures", "tisnik"));
        bugs.put(2,    new Bug("Frequent gcc SIGSEGV", "vendelin"));
        bugs.put(42,   new Bug("Typo in EAP doc", "tnguyen"));
        bugs.put(1234, new Bug("Midori crashes", "phatina"));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        doProcess(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        doProcess(request, response);
    }

    public void doProcess(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            System.out.println("do process");

            ServletContext servletContext = this.getServletContext();

            // ziskani parametru zadanych na formulari
            String bugId = request.getParameter("bug_id");
            System.out.println("bugId = " + bugId);

            String errorMessage = "";

            if (bugId == null || bugId.trim().equals("")) {
                errorMessage = "<p>Enter a bug ID into the text area</p>";
                bugId = "";
            }
            else {
                try {
                    // zkusime najit bugu v "databazi"
                    int id = Integer.parseInt(bugId);
                    if (bugs.containsKey(id)) {
                        Bug bug = bugs.get(id);
                        request.setAttribute("bugTitle", bug.title);
                        request.setAttribute("bugOwner", bug.owner);
                    }
                    else {
                        errorMessage = "<p style='blue'>Bug '" + bugId + "' not found!</p>";
                    }
                }
                catch (NumberFormatException e) {
                    errorMessage = "<p style='color:red'>Value '" + bugId + "' is not a valid bug ID!</p>";
                }
            }

            // nastaveni parametru pro JSP stranku
            request.setAttribute("bugID", bugId);
            request.setAttribute("errorMessage", errorMessage);

            // presmerovani na JSP stranku
            servletContext.getRequestDispatcher("/findbug.jsp").forward(request, response);
    }
}

