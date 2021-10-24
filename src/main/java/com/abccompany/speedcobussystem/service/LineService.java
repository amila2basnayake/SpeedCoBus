package com.abccompany.speedcobussystem.service;

import com.abccompany.speedcobussystem.model.Bus;
import com.abccompany.speedcobussystem.model.Line;
import com.abccompany.speedcobussystem.repository.LineRepository;
import com.abccompany.speedcobussystem.service.exception.LineException;
import org.springframework.stereotype.Service;

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
}
