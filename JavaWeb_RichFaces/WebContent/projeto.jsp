<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<%--

	RICHFACES --> COMPONENTE visual para o JSF
	A4J --> Ajax para JSF

--%>

<f:view>

	<h:outputText value="Coti Infomática - Web Developer"/>
	<hr size="1"/>
	<h:outputText value="Aula de RichFaces e Hibernate"/>
	
	<a4j:form>
	
		<h:panelGrid columns="2">
		
			<h:outputLabel value="Informe seu nome:" for="nome"/>
			<h:inputText id="nome" value="#{controle.pessoa.nome}"/>
			<h:outputLabel value="Data de nascimento:" for="datanasc"/>
			<rich:calendar id="datanasc" datePattern="dd/MM/yyyy" value="#{controle.pessoa.datanascimento}"/>
		
		</h:panelGrid>
		
		<br/>
		
		<a4j:commandButton value="Cadastrar Pessoa" action="#{controle.cadastrar}" reRender="formulario, consulta"/>
		<h:messages/>
	
	</a4j:form>
	
	<a4j:form id="consulta">
	
		<rich:dataTable id="tabela" width="40%" border="1" rows="5" value="#{controle.dados}" var="p">
		
			<rich:column>
					<f:facet name="header">
						<h:outputText value="Código"/>
					</f:facet>
					<h:outputText value="#{p.idpessoa}"/>
			</rich:column>
			
			<rich:column>
				<f:facet name="header">
					<h:outputText value="nome da Pessoa"/>
				</f:facet>
				<h:outputText value="#{p.nome}"/>
			</rich:column>
			
			<rich:column>
				<f:facet name="header">
					<h:outputText value="Data de Nascimento"/>
				</f:facet>
				<h:outputText value="#{p.datanascimento}">
					<f:convertDateTime pattern="EE, dd/MM/yyyy"/>
				</h:outputText>
			</rich:column>
		
		</rich:dataTable>
		
		<rich:datascroller for="tabela" reRender="consulta" align="left"/>
	
	</a4j:form>

</f:view>