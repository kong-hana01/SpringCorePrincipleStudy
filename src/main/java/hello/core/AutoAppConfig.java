package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

// Component가 붙은 클래스를 자동으로 스프링 빈으로 등록
@Configuration
@ComponentScan(
        // 만약 프로젝트 시작 위치에 이를 둔다면 아래의 값을 추가하지 않아도 됨
        basePackages = "hello.core.member", // 없으면 해당 패키지를 모두 다 뒤지기에 해당 패키지 하위에 있는 것만 탐색
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    @Bean(name = "memoryMemberRepository")
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
