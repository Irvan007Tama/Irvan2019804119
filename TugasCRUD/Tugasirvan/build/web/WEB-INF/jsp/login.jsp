<%-- 
    Document   : login
    Created on : Dec 2, 2021, 11:11:29 PM
    Author     : This-PC
--%>
<%@include file="/WEB-INF/jsp/include.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Aplikasi Mahasiswa</title>
    </head>
    <body>
        <form methode="GET" medelAttribute="emp" action="login/save.html">
            <table align="center">
                <tr>
                    <td>Username</td>
                    <td><input type="text" name="username"</td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Login"></td>
                </tr>
                <tr>
                    <td colspan="2">${massage}</td>
                </tr>
            </table>
        </form>
    </body>
</html>
