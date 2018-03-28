package main.factories;

import main.dtos.GorillaAndRelationDTO;
import main.entities.Gorilla;
import main.processors.*;

import java.util.List;
import java.util.NoSuchElementException;

public class RelationFactory {
    public static final String MOTHER = "MOTHER";
    public static final String FATHER = "FATHER";
    public static final String SON = "SON";
    public static final String DAUGHTER = "DAUGHTER";
    public static final String CHILDREN = "CHILDREN";
    public static final String BROTHERS = "BROTHERS";
    public static final String SISTERS = "SISTERS";
    public static final String GRAND_DAUGHTER = "GRAND_DAUGHTER";
    public static final String PATERNAL_UNCLE = "PATERNAL_UNCLE";
    public static final String MATERNAL_UNCLE = "MATERNAL_UNCLE";
    public static final String PATERNAL_AUNT = "PATERNAL_AUNT";
    public static final String MATERNAL_AUNT = "MATERNAL_AUNT";
    public static final String SISTER_IN_LAW = "SISTER_IN_LAW";
    public static final String BROTHER_IN_LAW = "BROTHER_IN_LAW";
    public static final String COUSINS = "COUSINS";

    public static RelationProcessor getRelationProcessor(List<Gorilla> gorillaList, GorillaAndRelationDTO gorillaAndRelationDTO) {
        switch (gorillaAndRelationDTO.getRelation().toUpperCase()) {
            case MOTHER:
                return new MotherProcessor(gorillaList, gorillaAndRelationDTO.getGorilla());
            case FATHER:
                return new FatherProcessor(gorillaList, gorillaAndRelationDTO.getGorilla());
            case SON:
                return new SonProcessor(gorillaList,gorillaAndRelationDTO.getGorilla());
            case DAUGHTER:
                return new DaughterProcessor(gorillaList, gorillaAndRelationDTO.getGorilla());
            case CHILDREN:
                return new ChildrenProcessor(gorillaList, gorillaAndRelationDTO.getGorilla());
            case BROTHERS:
                return new BrothersProcessor(gorillaList, gorillaAndRelationDTO.getGorilla());
            case SISTERS:
                return new SistersProcessor(gorillaList, gorillaAndRelationDTO.getGorilla());
            case GRAND_DAUGHTER:
                return new GrandDaughterProcessor(gorillaList, gorillaAndRelationDTO.getGorilla());
            case PATERNAL_UNCLE:
                return new PaternalUncleProcessor(gorillaList, gorillaAndRelationDTO.getGorilla());
            case MATERNAL_UNCLE:
                return new MaternalUncleProcessor(gorillaList, gorillaAndRelationDTO.getGorilla());
            case PATERNAL_AUNT:
                return new PaternalAuntProcessor(gorillaList, gorillaAndRelationDTO.getGorilla());
            case MATERNAL_AUNT:
                return new MaternalAuntProcessor(gorillaList, gorillaAndRelationDTO.getGorilla());
            case SISTER_IN_LAW:
                return new SisterInLawProcessor(gorillaList, gorillaAndRelationDTO.getGorilla());
            case BROTHER_IN_LAW:
                return new BrotherInLawProcessor(gorillaList, gorillaAndRelationDTO.getGorilla());
            case COUSINS:
                return new CousinsProcessor(gorillaList, gorillaAndRelationDTO.getGorilla());
            default:
                throw new NoSuchElementException(String.format("no relation with name %s", gorillaAndRelationDTO.getRelation()));
        }
    }
}
