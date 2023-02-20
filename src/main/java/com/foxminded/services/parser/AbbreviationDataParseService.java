package com.foxminded.services.parser;

import java.util.List;

import com.foxminded.model.AbbreviationData;
import com.foxminded.model.FormulasLogsData;

public class AbbreviationDataParseService extends ParseService {

    @Override
    protected void parseList(List<FormulasLogsData> list, String line) {
        String[] lineData = line.split(LINE_DATA_SPLIT_CHARACTER);
        list.add(new AbbreviationData(lineData[0], lineData[1], lineData[2]));
    }

    public AbbreviationDataParseService(String FILE_PATH) {
        super(FILE_PATH);
    }
}
