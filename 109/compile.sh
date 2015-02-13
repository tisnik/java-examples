# how to compile (OpenJDK6)
# - you need to figure out how to fix it to use JDK7/JDK8 :-)

javac Example1.java
javah Example1

gcc -Wall -ansi -O0 -shared -fPIC \
    -I/usr/lib/jvm/java-1.6.0-openjdk/include/\
    -I/usr/lib/jvm/java-1.6.0-openjdk/include/linux \
    -o libbar.so Example1.c

