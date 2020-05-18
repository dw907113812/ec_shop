package org.fkjava.ecshop.contrller;

import org.fkjava.ecshop.domain.ArticleType;
import org.fkjava.ecshop.service.EcShopService;
import org.fkjava.ecshop.service.impl.EcShopServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class IndexController extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进到index.jsp");

        //创建service对象
        EcShopService service = new EcShopServiceImpl();


        //获取所以的一级物品类型
        List<ArticleType> firstTypes = service.findAllFArticleType();
        System.out.println(firstTypes.size());

        //存数据
        request.setAttribute("firstTypes",firstTypes);

        request.getRequestDispatcher("/jsp/list.jsp").forward(request,response);

    }
}
