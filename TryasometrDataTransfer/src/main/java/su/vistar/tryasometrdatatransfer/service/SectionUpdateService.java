package su.vistar.tryasometrdatatransfer.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import su.vistar.tryasometrdatatransfer.mapper.TryasometrMapper;
import su.vistar.tryasometrdatatransfer.model.PitDto;
import su.vistar.tryasometrdatatransfer.model.Section;

/**
 *
 * @author Vitaliy
 */
@Service
public class SectionUpdateService {
    @Autowired
    TryasometrMapper tryasometrMapper;
    
    public void updateSectionValues (List<Section> sections, PitDto pit){
        sections.stream().map((section) -> {
            if (pit.getValue() - 1 < 0.001) {
                section.setSectionValue(0.1f * (pit.getValue().floatValue()) + 0.9f * section.getSectionValue());
            }
            else {
                section.setSectionValue(0.5f * (pit.getValue().floatValue()) + 0.5f * section.getSectionValue());
            }
            return section;
        }).forEach((section) -> {
            tryasometrMapper.updateSectionValue(section.getSectionValue(), section.getSectionID());
        });
    };
}
