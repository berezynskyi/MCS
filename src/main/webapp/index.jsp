<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entity.ConscriptCard" %>
<%@ page import="dao.ConscriptCardDAO" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 
Developed and designed by Maxym Berezynskyi & Anton Netudykhata
-->
<html>
    <c:set var="root" value="${pageContext.request.contextPath}" />
    <head>
       <title>Військкомат міста Києва</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" href="${root}/css/styles.css">
        <link rel="shortcut icon" href="${root}/images/favicon.ico">
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.1/jquery.min.js"></script>
        <script type="text/javascript" src="${root}/js/jquery.liveFilter.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                $('table.conscriptCard_table').liveFilter('fade');
            });
        </script>
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

                <div class="layout-column-2 layout-column">
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
                        <label  class="label-search" for="livefilter">Пошук: </label>
                        <input class="filter" name="livefilter" id="livefilter" type="text" value="">
                        <table class="conscriptCard_table">
                            <c:forEach var="card" items="${cards}">
                                <tr class="filling" onclick="window.location.href='/MCS/Profile?id=${card.idconscriptCardId}'; return false">
                                    <td>${card.surname}</td>
                                    <td>${card.name}</td>
                                    <td>${card.fathersName}</td>
                                </tr>
                            </c:forEach>
                        </table>
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