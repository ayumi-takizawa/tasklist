<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>タスクリスト</title>
</head>
<body>
    <div id="wrapper">
        <div id="headr">
            <h1>タスクリスト アプリケーション</h1>
        </div>
        <div id="content">${param.content}</div>       <!-- ここに各ページのビューの内容が入る -->
        <div id="footer">by Ayumi Takizawa</div>
    </div>

</body>
</html>