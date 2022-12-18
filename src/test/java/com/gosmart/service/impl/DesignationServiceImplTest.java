package com.gosmart.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gosmart.exception.GoSmartException;
import com.gosmart.repository.DesignationRepository;
import com.gosmart.repository.entity.DesignationEntity;

@RunWith(SpringJUnit4ClassRunner.class)
public class DesignationServiceImplTest {
	@InjectMocks
	private DesignationServiceImpl service;
	@Mock
	private DesignationRepository repository;
	@Test
	public void testInsertDesignation()throws Exception
	{
		DesignationEntity designationEntity=new DesignationEntity();
		DesignationEntity designationEntity2=Mockito.any();
		when(repository.save(designationEntity)).thenReturn(designationEntity2);
		Integer designationId=service.insertDesignation(designationEntity); 
		assertNotNull(designationId);
	}
	@Test(expected = GoSmartException.class)
	public void testInsertDesignation_Exception()throws Exception
	{
		DesignationEntity designationEntity=new DesignationEntity();
		when(repository.save(designationEntity)).thenThrow(NullPointerException.class);
		service.insertDesignation(designationEntity); 
	}
	@Test
	public void testGetDesignations()throws Exception
	{
		
		List<DesignationEntity> designationList=new ArrayList<>();
		when(repository.findAll()).thenReturn(designationList);
		List<DesignationEntity> designations=service.getDesignations(); 
		assertNotNull(designations);
	}
	@Test(expected = GoSmartException.class)
	public void testGetDesignations_Exception()throws Exception
	{
		
		when(repository.findAll()).thenThrow(NullPointerException.class);
		service.getDesignations(); 
	}
	

}
