package com.hexagonal.task.infrastructure.adapters;

import com.hexagonal.task.domain.models.AdditionalTaskInfo;
import com.hexagonal.task.domain.ports.out.ExternalServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ExternalServiceAdapter implements ExternalServicePort {

    private final RestTemplate restTemplate;

    public ExternalServiceAdapter() {
        this.restTemplate = new RestTemplate();
    }


    @Override
    public AdditionalTaskInfo getAdditonalTaskInfo(String id) {
        ResponseEntity<JsonPlaceHolderTodo> todoResponse = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/todos/" + id, JsonPlaceHolderTodo.class);

        JsonPlaceHolderTodo todo = todoResponse.getBody();

        if (todo == null) {
            return null;
        }

        ResponseEntity<JsonPlaceHolderUser> userResponse = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/users/" + todo.getUserId(), JsonPlaceHolderUser.class);

        JsonPlaceHolderUser user = userResponse.getBody();

        if (user == null) {
            return null;
        }

        return new AdditionalTaskInfo(todo.getId(), user.getName(), user.getEmail());

    }

    private static class JsonPlaceHolderTodo {

        private Long id;
        private Long userId;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }
    }

    private static class JsonPlaceHolderUser {

        private Long id;
        private String name;
        private String email;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
