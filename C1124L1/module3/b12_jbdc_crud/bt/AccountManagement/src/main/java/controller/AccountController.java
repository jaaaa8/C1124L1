package controller;

import entity.Account;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.AccountService;
import service.IAccountService;

import java.io.IOException;
import java.io.Serial;

@WebServlet (name = "AccountServerlet", urlPatterns = "/accounts")
public class AccountController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    private final IAccountService accountService = new AccountService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                // handle create account
                addAccount(req, resp);
                break;
            case "delete":
                // handle edit account
                deleteAccount(req, resp);
                break;
            case "update":
                // handle update account
                updateAccount(req, resp);
                break;
            case "list":
                // handle list account
                showAccountList(req, resp);
                break;
            default:
                // handle default action
                break;
        }
    }

    private void updateAccount(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String newPassword = req.getParameter("password");
        String newEmail = req.getParameter("email");
        String newRole = req.getParameter("role");
        Account account = this.accountService.findAccountById(id);
        RequestDispatcher dispatcher;
        if (account == null) {
            req.setAttribute("error", "Account doesn't exist to update!");
            dispatcher = req.getRequestDispatcher("/accounts/list.jsp");
        } else {
            account.setPassword(newPassword);
            account.setEmail(newEmail);
            account.setRole(newRole);
            this.accountService.updateAccount(account);
            req.setAttribute("account", account);
            req.setAttribute("message", "Account updated successfully");
            dispatcher = req.getRequestDispatcher("view/account/update.jsp");
        }
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private void deleteAccount(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Account account = this.accountService.findAccountById(id);

        if (account == null) {
            resp.sendRedirect("/accounts");
            return;
        }

        this.accountService.deleteAccount(account);
        resp.sendRedirect("/accounts");
    }


    private void addAccount(HttpServletRequest req, HttpServletResponse resp) {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        String email = req.getParameter("email");
        Account newAccount = new Account(userName,password,role,email);
        this.accountService.addAccount(newAccount);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/account/add.jsp");
        req.setAttribute("message", "New account was created");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                // handle create product
                showAddForm(req, resp);
                break;
            case "delete":
                // handle edit product
                showDeleteForm(req, resp);
                break;
            case "list":
                // handle list products
                showAccountList(req, resp);
                break;
            case "update":
                // handle update product
                showUpdateForm(req, resp);
                break;
            default:
                // handle default action
                showAccountList(req, resp);
                break;
        }
    }

    private void showUpdateForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Account account = this.accountService.findAccountById(id);
        RequestDispatcher dispatcher;
        if (account == null) {
            req.setAttribute("error", "Account doesn't exist");
            dispatcher = req.getRequestDispatcher("view/error.jsp");
        }else {
            req.setAttribute("account", account);
            dispatcher = req.getRequestDispatcher("view/account/update.jsp");
        }
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException | IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private void showAccountList(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("accounts", this.accountService.findAllAccounts());
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/account/list.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            System.err.println(e.getMessage());
        }
    }


    private void showDeleteForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Account account = this.accountService.findAccountById(id);
        RequestDispatcher dispatcher;
        if (account == null) {
            dispatcher = req.getRequestDispatcher("view/error.jsp");
        } else {
            req.setAttribute("account", account);
            dispatcher = req.getRequestDispatcher("view/account/delete.jsp");
        }
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException | IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private void showAddForm(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/account/add.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException | IOException e) {
            System.err.println(e.getMessage());
        }
    }

}
