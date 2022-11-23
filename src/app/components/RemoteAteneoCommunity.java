package app.components;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RemoteAteneoCommunity {
	@GET("http://localhost:9999/students/find")
	Call<StudentDto> student(@Query("studentId") int studentId);

	@GET("http://localhost:9999/professors/find")
	Call<ProfessorDto> professor(@Query("employeeId") int employeeId);
}
