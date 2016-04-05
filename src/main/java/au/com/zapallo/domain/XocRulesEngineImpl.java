package au.com.zapallo.domain;

import au.com.zapallo.repositories.dao.XocBreDAO;
import org.kie.api.io.ResourceType;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.runtime.StatefulKnowledgeSession;
import au.com.zapallo.repositories.crud.XocBreCRUD;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aaron.spiteri on 3/03/2016.
 */
public class XocRulesEngineImpl {

    @Autowired
    XocBreCRUD xocBreCRUD;

    KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
    KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
    StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
    List facts = new ArrayList();

    public void buildResources(Class className) {
        for (XocBreDAO rule : xocBreCRUD.findByClassName(className.toString())) {
            kbuilder.add(
                    ResourceFactory.newClassPathResource(
                            rule.getResourceLocation(),
                            className),
                    ResourceType.getResourceType(rule.getResourceType())
            );
        }
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
    }

    public void setFacts(List facts) {
        this.facts = facts;
    }

    public void executeBusinessRules() {
        for (Object fact : facts) {
            ksession.insert(fact);
        }
        ksession.fireAllRules();
    }

}
