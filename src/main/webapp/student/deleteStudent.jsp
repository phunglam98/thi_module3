<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <title>Student</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>"/>
</head>
<body>
<div class="header">
    <h3>Xóa thông tin sinh viên</h3>
    <p>Bạn có chắc chắn muốn xóa sinh viên này không?</p>
</div>
<div class="row">
    <div class="col-2"></div>
    <div class="col-8">
        <form action="/student?action=delete" method="post">
            <input type="hidden" name="id" value="${student.id}">
            <div class="form-group">
                <label for="inputName">Name</label>
                <input type="text" class="form-control" id="inputName" name="name" placeholder="Enter name" value="${student.name}" readonly>
            </div>
            <div class="form-group">
                <label for="inputEmail">Email</label>
                <input type="text" class="form-control" id="inputEmail" name="email" placeholder="Enter email" value="${student.email}" readonly>
            </div>
            <div class="form-group">
                <label for="inputDOB">Date of Birth</label>
                <input type="text" class="form-control" id="inputDOB" name="DOB"
                       placeholder="Enter date of birth as DD/MM/YYYY" value="${student.DOB}" readonly>
            </div>
            <div class="form-group">
                <label for="inputAddress">Address</label>
                <input type="text" class="form-control" id="inputAddress" name="address"
                       placeholder="Enter address" value="${student.address}" readonly>
            </div>
            <div class="form-group">
                <label for="inputPhone">Phone number</label>
                <input type="text" class="form-control" id="inputPhone" name="phone"
                       placeholder="Enter phone number" value="${student.phone}" readonly>
            </div>
            <div class="form-group">
                <label>Class</label>
                <input class="form-control" name="idClass" value="${student.classroom.name}" readonly>
            </div>
            <div class="modal-footer">
                <a href="/student?action=manager" class="btn btn-secondary">Cancel</a>
                <button type="submit" class="btn btn-danger">Submit</button>
            </div>
        </form>
    </div>
    <div class="col-2"></div>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
        crossorigin="anonymous"></script>
</body>
</html>