package baby.shark.servlets;

import baby.shark.Synchronize.Buffer;
import baby.shark.Synchronize.SynchronizeBuffer;
import baby.shark.models.ChangeClass;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@WebServlet(name = "ServletChange")
public class ServletChange extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        // create SynchronizedBuffer to store ints
        Buffer sharedLocation = new SynchronizeBuffer();
        executorService.execute(new ChangeClass(sharedLocation));
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
