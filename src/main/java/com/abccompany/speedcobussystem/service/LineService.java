package com.abccompany.speedcobussystem.service;


import com.abccompany.speedcobussystem.model.Line;
import com.abccompany.speedcobussystem.model.criteria.SearchCriteria;
import com.abccompany.speedcobussystem.repository.LineRepository;
import com.abccompany.speedcobussystem.repository.specification.LineSpecification;
import com.abccompany.speedcobussystem.exception.LineException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LineService {

    private final LineRepository lineRepository;


    public LineService(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    public Line getLine(Long id) {
        return lineRepository.findById(id).orElseThrow(() -> new LineException(id));
    }

    public Line createLine(Line line) {
        return lineRepository.save(line);
    }

    public Line removeLineByName(String name) {
        Line line = findLineByName(name);
        lineRepository.delete(line);
        return line;
    }

    private Line findLineByName(String name) {
        return lineRepository.findLineByName(name);
    }


    public List<Line> searchLineByNameAndId(Line line) {
        LineSpecification spec =
                new LineSpecification(new SearchCriteria("name", ":", line.getName()));
        LineSpecification spec1 =
                new LineSpecification(new SearchCriteria("id", ":", line.getId()));

        List<Line> results = lineRepository.findAll(Specification.where(spec).or(spec1));
        return results;
    }

    public Line searchLineByName(String name) {
        return lineRepository.findLineByName(name);
    }
}
