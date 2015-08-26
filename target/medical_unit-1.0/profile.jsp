<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entity.ConscriptCard" %>
<%@ page import="dao.ConscriptCardDAO" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--
  Created by IntelliJ IDEA.
  User: Max Berezynskyi
  Date: 20.03.2015
  Time: 17:59
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
            <div class="profile_column">
                <div class="profile-header">
                    <div class="profile-text">
                        <h2><p>Profile</p></h2>
                    </div>
                              <div class="unitImage">
                                  <a href="/MCS/MedUnit?id=${card.idconscriptCardId}">
                                      <img height="20px" width="20px" src="${root}/images/medicalUnit.jpg"/></a>
                              </div>
                </div>
                        <div class="profileImage">
                            <img height="150px" src="${root}/images/profile.png"/>
                        </div>
                        <div class="profileText">
                            <div class="profileTextKey">
                                <p>Ім'я : </p>
                                <p>Призвіще : </p>
                                <p>По-батькові : </p>
                                <p>Дата народження : </p>
                                <p>Місце проживання : </p>
                                <p>Паспортні дані : </p>
                                <p>Номер телефону : </p>
                            </div>
                            <div class="profileTextValue">
                                <p id="profileName">${card.name}</p>
                                <p id="profileSurname">${card.surname}</p>
                                <p id="profileFathersName">${card.fathersName}</p>
                                <p id="profileBirth">${card.dateOfBirth}</p>
                                <p id="profileAdress">${card.adress}</p>
                                <p id="profilePassport">${card.passportData}</p>
                                <p id="profilePhoneNumber">${card.phoneNumber}</p>
                            </div>
                        </div>

            <form  class="checkpass" action="/MCS/Profile?id=${card.idconscriptCardId}" method="post" accept-charset="UTF-8">
                <div class="textarea-comment">
                <textarea name="comment" id="comment-field" rows="10" cols="50" placeholder="Коментар лікаря">${comment}</textarea>
                </div>
                <div  class="check-password">
                    <div class="password-place">
                        <label for="password-text">Ваш пароль:</label><br>
                        <input type="password" name="password" size="10" id="password-text" placeholder="Пароль" required>
                    </div>

                    <div class="button-send">
                <input type="submit" value="Відправити">
                    </div>

                </div>
            </form>
            </div>
            <div class="result-popup">${notpass}</div>
        </div>

        <div class="layout-column">

        </div>
    </div>
</div>
<div class="footer clearfix">
</div>
</body>
</html>
