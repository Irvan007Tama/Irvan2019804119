<%-- 
    Document   : mahasiswa-form
    Created on : Dec 4, 2021, 12:02:19 AM
    Author     : This-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Input</title>
    </head>
    <body>
        <div class="container">
            <h1>Add Pembayaran ${message}</h1><hr/>
            <div class="row">
                <div class="col-md-4">
                    <form action="mahasiswa-form.html" modelAttribute="mhs" method="POST">
                        <div class="form-group">
                            <input type ="text" class="form-control" name="nim" placeholder="Nim" value="${mhs.nim}"/>
                        </div>
                        <div class="form-group">
                            <input type ="text" class="form-control" name="nama" placeholder="Nama" value="${mhs.nama}"/>
                        </div>
                        <div class="form-group">
                            <input type ="text" class="form-control" name="kelas" placeholder="Jumlah" value="${mhs.jumlah}"/>
                        </div>
                        <div class="form-group">
                            <input type ="text" class="form-control" name="jurusan" placeholder="Keterangan" value="${mhs.keterangan}"/>
                        </div>
                        <input type="hidden" name="id" value="${mhs.id}"/>
                        <button type="submit" class="btn btn-primary">Save</button>
                    </form>
                </div>
            </div>
            <a href="${pageContext.request.contextPath}/home.html"/>Back</a>
        </div>
    </body>
</html>
