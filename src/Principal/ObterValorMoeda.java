package Principal;

public class ObterValorMoeda {

	public Double converterMoeda(String moeda, Double valor) {

		if (moeda.equalsIgnoreCase("dolar")) {
			// valor moeda dia 16/05/2021
			return valor * 5.27;

		} else if (moeda.equalsIgnoreCase("euro")) {

			// valor moeda dia 16/05/2021
			return valor * 6.40;

		} else if (moeda.equalsIgnoreCase("libra")) {

			// valor moeda dia 16/05/2021
			return valor * 7.43;
		}

		return null;
	}

}
