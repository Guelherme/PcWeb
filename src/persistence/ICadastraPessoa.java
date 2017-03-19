package persistence;

import java.sql.SQLException;

import model.Pessoa;
import model.PessoaMensagens;

public interface ICadastraPessoa {

	public void cadastraPessoa(Pessoa pessoa, PessoaMensagens pm) throws SQLException;
	
}
