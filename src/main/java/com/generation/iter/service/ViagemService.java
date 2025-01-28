package com.generation.iter.service;


import org.springframework.stereotype.Service;
import com.generation.iter.model.ViagemModel;


@Service
public class ViagemService {
	
	public void calcularTempoViagem(ViagemModel viagem) {
		
		
	Double tempo = (viagem.getDistancia()/viagem.getVelMedia());	
	viagem.setTempoViagem(tempo);	
	
			
		
	}
	
	

}
