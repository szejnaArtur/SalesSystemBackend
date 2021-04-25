package pl.arturszejna.SalesSystemBackend.dto;

import lombok.Data;
import pl.arturszejna.SalesSystemBackend.entity.Unit;

import java.util.ArrayList;
import java.util.List;

@Data
public class UnitDTO {

    private Long idUnit;
    private String name;

    private UnitDTO(Long idUnit, String name) {
        setIdUnit(idUnit);
        setName(name);
    }

    public static UnitDTO of(Unit unit) {
        return new UnitDTO(unit.getIdUnit(), unit.getName());
    }

    public static List<UnitDTO> of(List<Unit> unitList) {
        List<UnitDTO> unitDTOList = new ArrayList<>();
        for (Unit unit : unitList) {
            unitDTOList.add(UnitDTO.of(unit));
        }
        return unitDTOList;
    }

}
