<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="../layout/header.jsp" %>

<div class="container">
    <form>
        <div class="form-group">
            <label for="title">Title</label>
            <input type="text" class="form-control" placeholder="Enter title" id="title">
        </div>

        <div class="form-group">
            <label for="content">Content</label>
            <textarea rows="3" cols="" id="content"></textarea>
        </div>

        <button id="btn-board-login" class="btn btn-primary"></button>
    </form>
</div>

<%@ include file="../layout/footer.jsp"%>