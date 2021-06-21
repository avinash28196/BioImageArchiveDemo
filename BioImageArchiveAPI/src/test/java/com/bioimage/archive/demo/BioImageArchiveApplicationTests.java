package com.bioimage.archive.demo;

import com.bioimage.archive.demo.controller.BioImageController;
import com.bioimage.archive.demo.model.Image;
import com.bioimage.archive.demo.model.ImageSizeResponseObject;
import com.bioimage.archive.demo.repository.ImageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
//@RunWith(SpringRunner.class)
@WebMvcTest(BioImageController.class)
class BioImageArchiveApplicationTests {

	@Autowired
	ImageRepository imageRepository;

	@Autowired
	private MockMvc mvc;


	@MockBean
	private BioImageController bioImageController;

	@Test
	void contextLoads() {
	}

	@Test
	public void getImageAccessionId() throws Exception{

		List<String> ids = new ArrayList<>();
		ids.add("BIA-01");
		ids.add("BIA-02");
		ids.add("BIA-03");

 		given(bioImageController.getAllAccessionId()).willReturn(ids);

 		mvc.perform(get("/images")
				.with(user("sa").password(""))
				.contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].accessionId", is(ids.get(0))));
	}


	@Test
	public void getImageSizeInformation() throws Exception {
		Image image = new Image();
		image.setAccessionId("BIA-01");
		ImageSizeResponseObject responseObject = new ImageSizeResponseObject();

		given(bioImageController.getImageSizeInformation(image.getAccessionId())).willReturn(responseObject);

		mvc.perform(get("/accessions/"+image.getAccessionId()+"/imageSize")
				.with(user("sa").password(""))
				.contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
				.andExpect(jsonPath("imagesize", is(120000000)));
	}

	@Test
	public void getMetaDataByAccessionId() throws Exception{
		Image metadata = new Image();

		String accessionID = "BIA-01";
		given(bioImageController.getImageMetaData(accessionID)).willReturn(metadata);


		mvc.perform(get("/accessions/"+accessionID+"/metadata")
				.with(user("sa").password(""))
				.contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
				.andExpect(jsonPath("$[0].accessionId", is(accessionID)));
	}

	@Test
	void checkTheNumberOfEntriesInDataBase(){
		List<Image> imageList = imageRepository.findAll();
		System.out.println(imageList.size());
	}

}
