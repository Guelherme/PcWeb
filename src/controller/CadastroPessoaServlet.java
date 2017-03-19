package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.CadastraPessoa;
import persistence.ICadastraPessoa;
import model.Pessoa;
import model.PessoaMensagens;

@WebServlet("/cadpessoa")
public class CadastroPessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CadastroPessoaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Pessoa p = new Pessoa();
		p.setCpf(request.getParameter("cpf"));
		p.setNome(request.getParameter("nome"));
		p.setTelefone(request.getParameter("telefone"));
		ICadastraPessoa cPes = new CadastraPessoa();
		PessoaMensagens pm = new PessoaMensagens();
		try {
			cPes.cadastraPessoa(p, pm);
		} catch (SQLException e) {
			pm.setMsgCadastro(e.getMessage());
		} finally {
			request.setAttribute("msgcpf", pm.getMsgCpf());
			request.setAttribute("msgcad", pm.getMsgCadastro());
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			view.forward(request, response);
		}
	}

}
