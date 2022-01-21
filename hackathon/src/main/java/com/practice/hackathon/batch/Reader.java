package com.practice.hackathon.batch;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.Resource;

import com.practice.hackathon.entity.User;


public class Reader extends FlatFileItemReader<User> {
	
	public Reader(Resource resource) {
		
		super();
		
		setResource(resource);
		
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames(new String[] { "firstName", "lastName", "dateOfBirth", "natinality","gender","primary_contact_number","secondary_contact_number","identificationId","identification_proof","email","address" });
		lineTokenizer.setDelimiter(",");
	    lineTokenizer.setStrict(false);
	    
	    BeanWrapperFieldSetMapper<User> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(User.class);

		DefaultLineMapper<User> defaultLineMapper = new DefaultLineMapper<>();
		defaultLineMapper.setLineTokenizer(lineTokenizer);
		defaultLineMapper.setFieldSetMapper(fieldSetMapper);
		setLineMapper(defaultLineMapper);
	}
}
