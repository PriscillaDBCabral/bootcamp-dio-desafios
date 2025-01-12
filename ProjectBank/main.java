public class Main {

	public static void main(String[] args) {
		Banco banco = new Banco();
		banco.setNome("Banco Priscilla");

		Cliente cliente1 = new Cliente();
		cliente1.setNome("Priscilla");
		cliente1.setEndereco("Rua das Flores, 123");
		cliente1.setRendaMensal(5000);

		Cliente cliente2 = new Cliente();
		cliente2.setNome("João");
		cliente2.setEndereco("Avenida Central, 456");
		cliente2.setRendaMensal(3000);

		Conta cc1 = new ContaCorrente(cliente1);
		Conta poupanca1 = new ContaPoupanca(cliente1);

		Conta cc2 = new ContaCorrente(cliente2);

		banco.adicionarConta(cc1);
		banco.adicionarConta(poupanca1);
		banco.adicionarConta(cc2);

		cc1.depositar(500);
		cc1.transferir(200, poupanca1);
		cc1.usarChequeEspecial(1000);
		cc1.aplicarJurosChequeEspecial();

		cc1.imprimirExtrato();
		poupanca1.imprimirExtrato();

		cc2.depositar(1000);
		cc2.sacar(300);
		cc2.imprimirExtrato();

		banco.listarContas();

		cliente1.solicitarEmprestimo(12, 2000, 5);
		cliente1.exibirEmprestimos();
	}
}


