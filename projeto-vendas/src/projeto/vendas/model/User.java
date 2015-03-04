package projeto.vendas.model;

public class User {
	private String usuario;
	private String senha;
	private String tipo_usuario;

	public User() {

	}

	public User(String usuario, String senha, String tipo_usuario) {
		this.usuario = usuario;
		this.senha = senha;
		this.tipo_usuario = tipo_usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipo_usuario() {
		return tipo_usuario;
	}

	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

}
