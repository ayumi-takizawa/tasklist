package controllers;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Task;
import utils.DBUtil;

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())) {      //CSRF対策のチェックを行なっている
            EntityManager em = DBUtil.createEntityManager();

            Task t = new Task();


            String content = request.getParameter("content");
            t.setContent(content);

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());     //現在日時の情報を持つ日付型オブジェクトの取得
            t.setCreated_at(currentTime);      //取得したオブジェクトを２つのカラムにセット
            t.setUpdated_at(currentTime);

            em.getTransaction().begin();
            em.persist(t);            //必要な情報をセットしたtaskクラスのオブジェクトをpersistメソッドを使ってデータベースにセーブ
            em.getTransaction().commit();    //セーブしたらコミット！
            em.close();

            response.sendRedirect(request.getContextPath() + "/index");       //データベースへ保存が完了したらindexページへリダイレクト
        }
    }

}
