<template>
	<section class="projects">
		<div class="container">
			<h2 class="section-title">Projects</h2>
			<div class="projects-grid">
				<div v-for="project in projects" :key="project.id" class="project-card">
					<div class="project-header">
						<h3 class="project-title">{{ project.name }}</h3>
						<div class="project-links">
							<a :href="project.cityUrl" target="_blank" class="project-link">
								<i class="fas fa-city"></i> City
							</a>
							<a :href="project.repoUrl" target="_blank" class="project-link">
								<i class="fab fa-github"></i> GitHub
							</a>
						</div>
					</div>
					<div class="project-description">
						{{ project.description }}
					</div>
					<div class="project-tech">
						<span v-for="tech in project.techStack" :key="tech" class="tech-tag">{{ tech }}</span>
					</div>
				</div>
			</div>
		</div>
	</section>
</template>

<script lang="ts">
export default {
	name: 'ProjectsView',
	data() {
		return {
			projects: [
				{
					id: 1,
					name: 'Mzansi Plaza',
					description: 'A modern e-commerce platform for local businesses with real-time inventory and order management.',
					techStack: ['Angular', 'Spring Boot', 'PostgreSQL', 'Docker'],
					cityUrl: 'https://www.johannesburg.za.com/',
					repoUrl: 'https://github.com/katlegomakoti/mzansi-plaza',
				},
				{
					id: 2,
					name: 'iRenew Store',
					description: 'A web app for renewable energy product sales and customer management.',
					techStack: ['Vue.js', 'Node.js', 'MongoDB'],
					cityUrl: 'https://www.capetown.gov.za/',
					repoUrl: 'https://github.com/katlegomakoti/irenew-store',
				},
				{
					id: 3,
					name: 'FootyFocus',
					description: 'A football analytics dashboard with live match stats and player insights.',
					techStack: ['React', 'Express', 'MySQL'],
					cityUrl: 'https://www.durban.gov.za/',
					repoUrl: 'https://github.com/katlegomakoti/footyfocus',
				},
				{
					id: 4,
					name: 'Tech-Oracle',
					description: 'A knowledge base and Q&A platform for tech professionals.',
					techStack: ['Salesforce', 'Apex', 'LWC'],
					cityUrl: 'https://www.pretoria.gov.za/',
					repoUrl: 'https://github.com/katlegomakoti/tech-oracle',
				},
			],
		}
	},
}
</script>

<style scoped>
.projects {
	padding: 5rem 0;
	min-height: 100vh;
	background-color: #f8f9fa;
}

.container {
	max-width: 1200px;
	margin: 0 auto;
	padding: 0 2rem;
}

.section-title {
	text-align: center;
	font-size: 2.5rem;
	margin-bottom: 3rem;
	color: #2c3e50;
}

.projects-grid {
	display: grid;
	grid-template-columns: repeat(auto-fit, minmax(350px, 1fr));
	gap: 2rem;
}

.project-card {
	background: white;
	border-radius: 15px;
	padding: 2rem;
	box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
	transition: transform 0.3s, box-shadow 0.3s;
	display: flex;
	flex-direction: column;
	justify-content: space-between;
}

.project-card:hover {
	transform: translateY(-8px) scale(1.02);
	box-shadow: 0 15px 30px rgba(52, 152, 219, 0.15);
}

.project-header {
	display: flex;
	justify-content: space-between;
	align-items: flex-start;
	margin-bottom: 1rem;
}

.project-title {
	font-size: 1.4rem;
	color: #2c3e50;
	font-weight: 700;
}

.project-links {
	display: flex;
	gap: 1rem;
}

.project-link {
	color: #3498db;
	font-size: 1rem;
	text-decoration: none;
	font-weight: 600;
	transition: color 0.2s;
}

.project-link:hover {
	color: #42b883;
}

.project-description {
	color: #34495e;
	margin-bottom: 1.2rem;
	font-size: 1rem;
	line-height: 1.6;
}

.project-tech {
	display: flex;
	flex-wrap: wrap;
	gap: 0.5rem;
}

.tech-tag {
	background: linear-gradient(90deg, #3498db, #42b883);
	color: white;
	padding: 0.4rem 0.8rem;
	border-radius: 12px;
	font-size: 0.85rem;
	font-weight: 500;
	margin-bottom: 0.3rem;
	transition: background 0.3s;
}

.tech-tag:hover {
	background: linear-gradient(90deg, #42b883, #3498db);
}

@media (max-width: 768px) {
	.projects-grid {
		grid-template-columns: 1fr;
	}
}
</style>
