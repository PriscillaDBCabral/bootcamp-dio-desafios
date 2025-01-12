import java.util.ArrayList;
import java.util.List;

public class Cliente {

	protected String nome;
	protected String endereco;
	protected double rendaMensal;
	protected List<String> emprestimos = new ArrayList<>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String novoEndereco) {
		this.endereco = novoEndereco;
	}

	public double getRendaMensal() {
		return rendaMensal;
	}

	public void setRendaMensal(double rendaMensal) {
		this.rendaMensal = rendaMensal;
	}

	public void solicitarEmprestimo(int numeroParcelas, double valor, int jurosPercentual) {
		String emprestimo = String.format("Emprestimo: Valor: %.2f, Parcelas: %d, Juros: %d%%", valor, numeroParcelas, jurosPercentual);
		emprestimos.add(emprestimo);
	}

	public void exibirEmprestimos() {
		System.out.println("=== Emprestimos do Cliente ===");
		for (String emprestimo : emprestimos) {
			System.out.println(emprestimo);
		}
	}
}
	
