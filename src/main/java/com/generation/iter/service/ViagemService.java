package com.generation.iter.service;

import org.springframework.stereotype.Service;
import com.generation.iter.model.ViagemModel;

@Service
public class ViagemService {
	
	public void calcularTempoViagem(ViagemModel viagem) {
	
	 double tempoHrs = viagem.getDistancia()/viagem.getVelMedia();

     int horas = (int) tempoHrs;
     int minutos = (int) ((tempoHrs - horas) * 60);
	
	String tempoViagem = (horas+"h"+minutos+"min"); 
	
	viagem.setTempoViagem(tempoViagem);
	
	}

}

