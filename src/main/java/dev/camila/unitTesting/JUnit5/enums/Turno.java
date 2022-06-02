package dev.camila.unitTesting.JUnit5.enums;

public enum Turno {
	MANHA {
		@Override
		public double porcentagemDesconto() {
			return 0.90d;
		}
	}, TARDE {
		@Override
		public double porcentagemDesconto() {
			return 0.95d;
		}
	}, NOITE {
		@Override
		public double porcentagemDesconto() {
			return 1d;
		}
	};
	
	public abstract double porcentagemDesconto();
}
