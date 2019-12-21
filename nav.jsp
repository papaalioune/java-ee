<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- DEBUT DE LA BARRE DE NAVIGATION -->
		<div id="navbar" class="navbar navbar-default          ace-save-state">
			<div class="navbar-container ace-save-state" id="navbar-container">
				<div class="navbar-header pull-left">
					<a href="index.html" class="navbar-brand">
						<small>
							<i class="fa fa-leaf"></i>
							Gestion Cours
						</small>
					</a>
				</div>

				<div class="navbar-buttons navbar-header pull-right" role="navigation">					
					<s:if test="#session.user">				            				            				            
				            	<ul class="nav ace-nav">
									<li class="light-blue dropdown-modal">
										<a data-toggle="dropdown" href="#" class="dropdown-toggle">
											<img class="nav-user-photo" src="<s:url value ="/static/images/avatars/user.jpg"/>" alt="Jason's Photo" />
											<span class="user-info">
												<small>Binevenu,</small>
												<s:property value="#session.user.prenom" />
				            					<s:property value="#session.user.nom" />
											</span>
			
											<i class="ace-icon fa fa-caret-down"></i>
										</a>
			
										<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
											<li>
												<a href="#">
													<i class="ace-icon fa fa-cog"></i>
													Settings
												</a>
											</li>
			
											<li>
												<a href="profile.html">
													<i class="ace-icon fa fa-user"></i>
													Profile
												</a>
											</li>
			
											<li class="divider"></li>
			
											<li>
												<s:a action="logout">
													<i class="ace-icon fa fa-power-off"></i>
													Déconnexion
												</s:a>
											</li>
										</ul>
									</li>
								</ul>
				    </s:if>
				    <s:else>
				    	<s:a action="login">
				    		<h5 style="color:white">						
								Connexion													
							</h5>	
				    	</s:a>				    				       
				    </s:else>
				    <!--<h5 style="color:red">						
						<s:actionerror/>
						<s:actionmessage/>													
					</h5>-->
				</div>				
			</div><!-- /.navbar-container -->					
		</div>
		<!-- FIN DE LA BARRE DE NAVIGATION -->