package com.electronic.esb.customer;

import com.electronic.esb.customer.Customer;
import jakarta.persistence.criteria.Predicate;
import io.micrometer.common.util.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public class CustomerSpecification {

    public static Specification<Customer> filterCustomer(String firstName, String lastName,String city) {
        return (root, query, criteriaBuilder) -> {
            Predicate firstNamePredicate = StringUtils.isBlank(firstName) ? criteriaBuilder.conjunction() :
            criteriaBuilder.like(root.get("firstName"),likePattern(firstName));


            Predicate lastNamePredicate = StringUtils.isBlank(lastName) ? criteriaBuilder.conjunction() :
                    criteriaBuilder.like(root.get("lastName"),likePattern(lastName));

            Predicate cityPredicate = StringUtils.isBlank(city) ? criteriaBuilder.conjunction() :
                    criteriaBuilder.like(root.get("city"),likePattern(city));


            return criteriaBuilder.and(firstNamePredicate, lastNamePredicate,cityPredicate);
        };
    }

    public static Specification<Customer> searchCustomer(String search) {
        return (root, query, criteriaBuilder) -> {
            Predicate firstNamePredicate = criteriaBuilder.like(root.get("firstName"), likePattern(search));
            Predicate lastNamePredicate = criteriaBuilder.like(root.get("lastName"), likePattern(search));
            Predicate cityPredicate = criteriaBuilder.like(root.get("city"), likePattern(search));
            return criteriaBuilder.or(firstNamePredicate,lastNamePredicate,cityPredicate);
        };
    }

    private static String likePattern(String value) {
        return "%" + value + "%";
    }
}
