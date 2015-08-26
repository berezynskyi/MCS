<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entity.ConscriptCard" %>
<%@ page import="dao.ConscriptCardDAO" %>
<%@ page import="dao.MedicalSpecialistDAO" %>
<%@ page import="controller.MedicalServlet" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--
  Created by IntelliJ IDEA.
  User: Max Berezynskyi
  Date: 22.03.2015
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<html>
<c:set var="root" value="${pageContext.request.contextPath}" />
<head>
    <title>Військкомат міста Києва</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="${root}/css/styles.css">
    <link rel="shortcut icon" href="${root}/images/favicon.ico">
</head>
<body>

<div class="header clearfix">
    <div class="layout-positioner">
        <div class="layout-column">
            <a href="/MCS/MedicalOffice"><img  src="${root}/images/gerb.png" class="header-img"></a>
            <div class="headerText">
                <p>Військкомат міста Києва</p>
            </div>
        </div>
    </div>
</div>
<div class="features clearfix">
    <div class="layout-positioner">
        <div class="layout-column">
            <div class="feature hidden">
                <div class="doc-style">Нормативно-правові документи</div>
                        <div class="documents">
                    <ul class="ul-docs">
                        <a href="${root}/docs/Pro_chastkovu_mobilizatsiyu__vid_14_01_15.pdf"><li>Про часткову мобілізацію</li></a>
                        <a href="${root}/docs/Pro_viyskovy_obov_39_yazok_i_viyskovu_sluzhbu__v.pdf"><li>Про військовий обов'язок і військову службу</li></a>
                    </ul>
                </div>
            </div>
        </div>
        <div class="layout-column">
            <div class="feature hidden">
                <div class="med-profile">
                    <c:forEach var="unit" items="${medUnits}">
                            <div class="filling-unit">

                                <b><i><p><c:out value="${MedicalServlet.getSpecFIO(unit.idMedicalSpecialist)}"/> :</p></i></b>
                                <p>${unit.comment}</p>
                            </div>
                    </c:forEach>
                </div>
            </div>
        </div>

        <div class="layout-column">
            <div class="feature hidden">

            </div>
        </div>
    </div>
</div>
<div class="footer clearfix">
</div>
</body>
</html>