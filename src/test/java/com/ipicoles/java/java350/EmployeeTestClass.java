package com.ipicoles.java.java350;

import com.ipiecoles.java.java350.model.Employe;
import com.ipiecoles.java.java350.repository.EmployeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;


public class EmployeeTestClass {
  //Matricule , l'ancienneté , performance , temps partiel , date d'ebauche
  @ParameterizedTest
  @CsvSource(
          {
                  "1,T12345, 0, 1.0, 1000.0"
          }
  )
  public void testPrimeAnnuelle(Integer performance , String matricule, Integer nbAnneesAnciennete ,Double tempsPartiel, Double prime){
    Employe employe = new Employe();
    employe.setMatricule(matricule);
    employe.setPerformance(performance);
    employe.setDateEmbauche(LocalDate.now().minusYears(nbAnneesAnciennete));
    employe.setTempsPartiel(tempsPartiel);

    //When
    Double primeCalculee = employe.getPrimeAnnuelle();

    //then
    Assertions.assertThat(primeCalculee).isEqualTo(prime);
  }
}
