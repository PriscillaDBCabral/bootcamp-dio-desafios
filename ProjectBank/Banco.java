import java.util.ArrayList;
import java.util.List;

public class Banco {

	private String nome;
	private List<Conta> contas = new ArrayList<>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void adicionarConta(Conta conta) {
		this.contas.add(conta);
	}

	public void listarContas() {
		System.out.println("=== Contas no Banco ===");
		for (Conta conta : contas) {
			System.out.println(String.format("Titular: %s - Agencia: %d - Conta: %d", conta.cliente.getNome(), conta.getAgencia(), conta.getConta()));
		}
	}
}
