public abstract class Conta implements IConta {

	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	protected double chequeEspecial;
	protected double jurosChequeEspecial = 0.1; // 10% ao mês

	public Conta(Cliente cliente) {
		this.agencia = AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		calcularChequeEspecial();
	}

	private void calcularChequeEspecial() {
		this.chequeEspecial = cliente.getRendaMensal() * 0.3; // 30% da renda como limite
	}

	public void usarChequeEspecial(double valor) {
		if (valor <= chequeEspecial) {
			saldo -= valor;
			System.out.println(String.format("Cheque especial usado: %.2f", valor));
		} else {
			System.out.println("Valor excede o limite do cheque especial.");
		}
	}

	public void aplicarJurosChequeEspecial() {
		if (saldo < 0) {
			double juros = Math.abs(saldo) * jurosChequeEspecial;
			saldo -= juros;
			System.out.println(String.format("Juros aplicados no cheque especial: %.2f", juros));
		}
	}

	@Override
	public void sacar(double valor) {
		saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}

	public int getAgencia() {
		return agencia;
	}

	public int getConta() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public double getChequeEspecial() {
		return chequeEspecial;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
		System.out.println(String.format("Cheque Especial: %.2f", this.chequeEspecial));
	}
}
