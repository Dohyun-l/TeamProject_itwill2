<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//post로 온 body를 받는 영역
String postBody = getBody.readBody(request);

JSONParser jsonParser = new JSONParser();
JSONObject postBodyObject = (JSONObject) jsonParser.parse(postBody);

String nowEmail = (String)postBodyObject.get("reqData");

//디비 호출

%>