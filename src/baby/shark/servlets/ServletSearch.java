package baby.shark.servlets;

import baby.shark.Synchronize.Buffer;
import baby.shark.Synchronize.SynchronizeBuffer;
import baby.shark.models.ChangeClass;
import baby.shark.models.Search;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@WebServlet(name = "ServletSearch")
public class ServletSearch extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String input=request.getParameter("textToFind");


        request.setAttribute("input", input);
        request.getRequestDispatcher("searchResult.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
