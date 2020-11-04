<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<label for="content">内容</label><br />
<input type="text" name="content" value="${task.content}" />   <!-- taskオブジェクトからデータを参照して入力内容の初期値として表示 -->
<br /><br />

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">書き込み</button>