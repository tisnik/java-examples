<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ page pageEncoding="utf-8" %>

<html>
    <head>
        <title>Demo app</title>
        <meta name="Generator" content="vim" />
        <meta http-equiv="content-type" content="text/html; charset=iso-8859-2" />
    </head>
    <body>
        <h1>Very simple servlet demo app</h1>

        <form method="get" action="findbug">
            Bug ID:
            <input type="text" name="bug_id" value='<%= request.getAttribute("bugID") %>'>
            <input type="submit" value="search">
        </form>

        <%= request.getAttribute("errorMessage") %>

        <% if (request.getAttribute("bugTitle") != null) { %>
        <table border>
            <tr><th>Bug ID:</th><td><%= request.getAttribute("bugID") %></td>
            <tr><th>Title: </th><td><%= request.getAttribute("bugTitle") %></td>
            <tr><th>Owner: </th><td><%= request.getAttribute("bugOwner") %></td>
        </table>
        <% } %>

        <br /><br /><br />
        <hr />
        <p>tisnik 2011-12-14</p>
    </body>
</html>

