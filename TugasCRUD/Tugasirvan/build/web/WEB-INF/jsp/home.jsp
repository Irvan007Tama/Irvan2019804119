<%-- 
    Document   : home
    Created on : Dec 2, 2021, 11:34:10 PM
    Author     : This-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="False" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pembayaran Kas Mahasiswa</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <h1>List Mahasiswa</h1>
        <p>
            <button class="btn btn-primary"
                onclick="window.location.href= 'mahasiswa-form.html'">
              Add Pembayaran
            </button>
        </p>
        <table class="table table-striped table-bordered">
            <tr class="thead-dark">
                <th>ID</th>
                <th>Nim</th>
                <th>Nama</th>
                <th>Jumlah</th>
                <th>Keterangan</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${listMahasiswa}" var="mhs">
                <tr>
                    <td>${mhs.id}</td>
                    <td>${mhs.nim}</td>
                    <td>${mhs.nama}</td>
                    <td>${mhs.jumlah}</td>
                    <td>${mhs.keterangan}</td>
                    <td>
                        <button class="btn btn-primary"
                                onclick="window.location.href='mahasiswa-form.html?action=edit&id=${mhs.id}'">
                        Edit
                        </button>
                        <button class="btn btn-danger"
                                onclick="window.location.href='mahasiswa-form.html?action=delete&id=${mhs.id}'">
                        Delete
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
