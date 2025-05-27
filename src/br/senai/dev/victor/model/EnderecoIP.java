package br.senai.dev.victor.model;

public class EnderecoIP {
	private String ip;
	private int cidr;

	public EnderecoIP(String entrada) {
		String[] partes = entrada.split("/");
		ip = partes[0];
		cidr = Integer.parseInt(partes[1]);
	}

	public String getClasse() {
		int primeiro = Integer.parseInt(ip.split("\\.")[0]);
		if (primeiro <= 127)
			return "Classe A";
		if (primeiro <= 191)
			return "Classe B";
		if (primeiro <= 223)
			return "Classe C";
		if (primeiro <= 239)
			return "Classe D";
		return "Classe E";
	}

	public String getMascaraDecimal() {
		int mascara = 0xFFFFFFFF << (32 - cidr);
		return (mascara >>> 24 & 0xFF) + "." + (mascara >>> 16 & 0xFF) + "." + (mascara >>> 8 & 0xFF) + "."
				+ (mascara & 0xFF);
	}

	public String getMascaraBinaria() {
		int mascara = 0xFFFFFFFF << (32 - cidr);
		return String.format("%8s.%8s.%8s.%8s",
				Integer.toBinaryString(mascara >>> 24 & 0xFF),
				Integer.toBinaryString(mascara >>> 16 & 0xFF),
				Integer.toBinaryString(mascara >>> 8 & 0xFF),
				Integer.toBinaryString(mascara & 0xFF)).replace(' ', '0');
	}

	public int getTotalIPs() {
		return (int) Math.pow(2, 32 - cidr) - 2;
	}

	public int getNumeroRedes() {
		int base;
		switch (getClasse()) {
			case "Classe A":
				base = 8;
				break;
			case "Classe B":
				base = 16;
				break;
			case "Classe C":
				base = 24;
				break;
			default:
				return -1; // Classes D e E não têm conceito de sub-rede
		}

		if (cidr <= base) return 1;
		return (int) Math.pow(2, cidr - base);
	}
}
