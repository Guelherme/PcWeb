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
		String sql = "{CALL sp_inserecpf(?,?,?,?,?)}";
		CallableStatement cs = c.prepareCall(sql);
		cs.setString(1, pessoa.getCpf());
		cs.setString(2, pessoa.getNome());
		cs.setString(3, pessoa.getTelefone());
		cs.registerOutParameter(4, Types.VARCHAR);
		cs.registerOutParameter(5, Types.VARCHAR);
		cs.execute();
		pm.setMsgCpf(cs.getString(4));
		pm.setMsgCadastro(cs.getString(5));
		cs.close();
	}

}