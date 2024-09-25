package com.varmeego.tsw3.s2sgateway.controller;

@Slf4j
@RestController
@RequestMapping("/client")
public class MyController {

    /**
     * This property bean is created in {@link SslConfig#webClient()}
     **/
    @Autowired
    WebClient webClient;

    /**
     * This controller method invokes the server using the wired bean
     * {@link this#webClient} and returns back the secured data from the server
     *
     * @return
     * @throws URISyntaxException
     * @throws IOException
     * @throws InterruptedException
     */
    @GetMapping
    public String gatherDataFromServer() {
        Mono<String> dateFromServer = webClient.get()
                .uri("https://localhost:8082/server")
                .retrieve().bodyToMono(String.class);
        return dateFromServer.block();
    }
}
