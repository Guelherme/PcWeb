package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import model.Pessoa;
import model.PessoaMensagens;

public class CadastraPessoa implements ICadastraPessoa {

	private Connection c;
	
	public CadastraPessoa() {
		GenericDao gDao = new GenericDao();
		c = gDao.getConnection();
	}
	
	@Override
	public void cadastraPessoa(Pessoa pessoa, PessoaMensagens pm)
			throws SQLException {
		String acao = "I";
		String sql = "{call sp_pessoa (?,?,?,?,?)}";
		CallableStatement cs = c.prepareCall(sql);
		cs.setString(1, acao);
		int cpf = Integer.parseInt(pessoa.getCpf());
		cs.setInt(2, cpf);
		cs.setString(3, pessoa.getNome());
		cs.setString(4, pessoa.getTelefone());
		cs.registerOutParameter(5, Types.VARCHAR);
		cs.execute();
		pm.setMsgCadastro(cs.getString(5));
		cs.close();
	}

}