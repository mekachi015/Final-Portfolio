<template>
	<section class="projects">
		<div class="container">
			<h2 class="section-title">Projects</h2>
			<p class="section-intro">A collection of projects I've built... spanning web apps and  dashboards. Each one reflects a problem I wanted to solve or a skill I wanted to sharpen.</p>

			<!-- Deployed -->
			<div class="section-group">
				<div class="group-label">
					<span class="group-dot group-dot--live"></span>
					Deployed
				</div>
				<div class="projects-grid">
					<div v-for="project in deployedProjects" :key="project.id" class="project-card">
						<div class="project-body">
							<div class="project-header">
								<h3 class="project-title">{{ project.name }}</h3>
								<div class="project-links">
									<a @click.prevent="visitSite(project)" href="#" class="project-link">
										<svg width="13" height="13" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2.5" stroke-linecap="round" stroke-linejoin="round"><path d="M18 13v6a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h6"/><polyline points="15 3 21 3 21 9"/><line x1="10" y1="14" x2="21" y2="3"/></svg>
										Site
									</a>
									<a :href="project.repoUrl" target="_blank" class="project-link">
										<svg width="13" height="13" viewBox="0 0 24 24" fill="currentColor"><path d="M12 0C5.37 0 0 5.37 0 12c0 5.3 3.438 9.8 8.205 11.385.6.113.82-.258.82-.577 0-.285-.01-1.04-.015-2.04-3.338.724-4.042-1.61-4.042-1.61-.546-1.385-1.335-1.755-1.335-1.755-1.087-.744.084-.729.084-.729 1.205.084 1.838 1.236 1.838 1.236 1.07 1.835 2.809 1.305 3.495.998.108-.776.417-1.305.76-1.605-2.665-.3-5.466-1.332-5.466-5.93 0-1.31.465-2.38 1.235-3.22-.135-.303-.54-1.523.105-3.176 0 0 1.005-.322 3.3 1.23.96-.267 1.98-.399 3-.405 1.02.006 2.04.138 3 .405 2.28-1.552 3.285-1.23 3.285-1.23.645 1.653.24 2.873.12 3.176.765.84 1.23 1.91 1.23 3.22 0 4.61-2.805 5.625-5.475 5.92.42.36.81 1.096.81 2.22 0 1.606-.015 2.896-.015 3.286 0 .315.21.69.825.57C20.565 21.795 24 17.295 24 12c0-6.63-5.37-12-12-12"/></svg>
										GitHub
									</a>
								</div>
							</div>
							<p class="project-description">{{ project.description }}</p>
							<div class="project-tech">
								<span v-for="tech in project.techStack" :key="tech" class="tech-tag">{{ tech }}</span>
							</div>
							<button class="view-images-btn" @click="openLightbox(project)">
								<svg width="15" height="15" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2.2" stroke-linecap="round" stroke-linejoin="round"><rect x="3" y="3" width="18" height="18" rx="2"/><circle cx="8.5" cy="8.5" r="1.5"/><polyline points="21 15 16 10 5 21"/></svg>
								View Images
								<span class="img-count">{{ project.images.length }}</span>
							</button>
						</div>
					</div>
				</div>
			</div>

			<!-- Pending Deployment -->
			<div class="section-group">
				<div class="group-label">
					<span class="group-dot group-dot--pending"></span>
					Pending Deployment
				</div>
				<div class="projects-grid">
					<div v-for="project in pendingProjects" :key="project.id" class="project-card project-card--pending">
						<div class="project-body">
							<div class="project-header">
								<h3 class="project-title">{{ project.name }}</h3>
								<div class="project-links">
									<a @click.prevent="visitSite(project)" href="#" class="project-link project-link--muted">
										<svg width="13" height="13" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2.5" stroke-linecap="round" stroke-linejoin="round"><path d="M18 13v6a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h6"/><polyline points="15 3 21 3 21 9"/><line x1="10" y1="14" x2="21" y2="3"/></svg>
										Site
									</a>
									<a :href="project.repoUrl" target="_blank" class="project-link">
										<svg width="13" height="13" viewBox="0 0 24 24" fill="currentColor"><path d="M12 0C5.37 0 0 5.37 0 12c0 5.3 3.438 9.8 8.205 11.385.6.113.82-.258.82-.577 0-.285-.01-1.04-.015-2.04-3.338.724-4.042-1.61-4.042-1.61-.546-1.385-1.335-1.755-1.335-1.755-1.087-.744.084-.729.084-.729 1.205.084 1.838 1.236 1.838 1.236 1.07 1.835 2.809 1.305 3.495.998.108-.776.417-1.305.76-1.605-2.665-.3-5.466-1.332-5.466-5.93 0-1.31.465-2.38 1.235-3.22-.135-.303-.54-1.523.105-3.176 0 0 1.005-.322 3.3 1.23.96-.267 1.98-.399 3-.405 1.02.006 2.04.138 3 .405 2.28-1.552 3.285-1.23 3.285-1.23.645 1.653.24 2.873.12 3.176.765.84 1.23 1.91 1.23 3.22 0 4.61-2.805 5.625-5.475 5.92.42.36.81 1.096.81 2.22 0 1.606-.015 2.896-.015 3.286 0 .315.21.69.825.57C20.565 21.795 24 17.295 24 12c0-6.63-5.37-12-12-12"/></svg>
										GitHub
									</a>
								</div>
							</div>
							<p class="project-description">{{ project.description }}</p>
							<div class="project-tech">
								<span v-for="tech in project.techStack" :key="tech" class="tech-tag">{{ tech }}</span>
							</div>
							<button class="view-images-btn" @click="openLightbox(project)">
								<svg width="15" height="15" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2.2" stroke-linecap="round" stroke-linejoin="round"><rect x="3" y="3" width="18" height="18" rx="2"/><circle cx="8.5" cy="8.5" r="1.5"/><polyline points="21 15 16 10 5 21"/></svg>
								View Images
								<span class="img-count">{{ project.images.length }}</span>
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Not Live popup -->
		<transition name="fade">
			<div v-if="notLivePopup" class="popup-overlay" @click.self="notLivePopup = false">
				<div class="popup">
					<div class="popup-icon">🚧</div>
					<h3 class="popup-title">Not Live Yet</h3>
					<p class="popup-msg">This project hasn't been deployed yet. Check back soon!</p>
					<button class="popup-close-btn" @click="notLivePopup = false">Got it</button>
				</div>
			</div>
		</transition>

		<!-- Lightbox Modal -->
		<transition name="fade">
			<div v-if="lightbox.open" class="lightbox-overlay" @click.self="closeLightbox">
				<div class="lightbox">
					<!-- Header -->
					<div class="lightbox-header">
						<span class="lightbox-title">{{ lightbox.project?.name }}</span>
						<button class="lightbox-close" @click="closeLightbox" aria-label="Close">
							<svg width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2.5" stroke-linecap="round" stroke-linejoin="round"><line x1="18" y1="6" x2="6" y2="18"/><line x1="6" y1="6" x2="18" y2="18"/></svg>
						</button>
					</div>

					<!-- Carousel -->
					<div class="lightbox-carousel">
						<div
							class="lightbox-track"
							:style="{ transform: `translateX(-${lightbox.index * 100}%)` }"
						>
							<div
								v-for="(img, i) in lightbox.project?.images"
								:key="i"
								class="lightbox-slide"
							>
								<img :src="img.src" :alt="img.alt" class="lightbox-img" />
							</div>
						</div>

						<!-- Prev / Next -->
						<button
							v-if="(lightbox.project?.images.length ?? 0) > 1"
							class="lb-btn lb-btn--prev"
							@click="lbPrev"
							aria-label="Previous"
						>
							<svg width="22" height="22" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2.5" stroke-linecap="round" stroke-linejoin="round"><polyline points="15 18 9 12 15 6"/></svg>
						</button>
						<button
							v-if="(lightbox.project?.images.length ?? 0) > 1"
							class="lb-btn lb-btn--next"
							@click="lbNext"
							aria-label="Next"
						>
							<svg width="22" height="22" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2.5" stroke-linecap="round" stroke-linejoin="round"><polyline points="9 18 15 12 9 6"/></svg>
						</button>
					</div>

					<!-- Footer: dots + counter -->
					<div class="lightbox-footer">
						<div class="lb-dots">
							<button
								v-for="(_, i) in lightbox.project?.images"
								:key="i"
								class="lb-dot"
								:class="{ 'lb-dot--active': lightbox.index === i }"
								@click="lightbox.index = i"
								:aria-label="`Image ${i + 1}`"
							></button>
						</div>
						<span class="lb-counter">{{ lightbox.index + 1 }} / {{ lightbox.project?.images.length }}</span>
					</div>

					<!-- Caption -->
					<p class="lightbox-caption">{{ lightbox.project?.images[lightbox.index]?.alt }}</p>
				</div>
			</div>
		</transition>
	</section>
</template>

<script lang="ts">
interface ProjectImage { src: string; alt: string }
interface Project {
	id: number; name: string; description: string;
	techStack: string[]; citeUrl: string; repoUrl: string;
	images: ProjectImage[]
}

export default {
	name: 'ProjectsView',
	data() {
		return {
			notLivePopup: false,
			lightbox: {
				open: false,
				index: 0,
				project: null as Project | null,
			},
			projects: [
				{
					id: 1,
					name: 'Tech-Oracle',
					description: 'A basic AI-powered repair guide generator, providing step-by-step instructions for common tech issues.',
					techStack: ['React', 'Python', 'MongoDB'],
					citeUrl: 'https://tech-oracle-amber.vercel.app/',
					repoUrl: 'https://github.com/mekachi015/Tech-Oracle',
					images: [
						{ src: '/project-screenshots/tech-oracle-user-form.png', alt: 'Tech-Oracle user form' },
						{ src: '/project-screenshots/tech-oracle-technician-portal.png', alt: 'Tech-Oracle technician portal' },
						{ src: '/project-screenshots/tech-oracle-technician-dashboad.png', alt: 'Tech-Oracle technician dashboard' },
						{ src: '/project-screenshots/tech-oracle-repair-guide.png', alt: 'Tech-Oracle repair guide' },
						{ src: '/project-screenshots/tech-oracle-repair-guide2.png', alt: 'Tech-Oracle repair guide step' },
						{ src: 'project-screenshots/tech-oracle-repair-guide3.png', alt: 'Tech-oracle repair guide 3'}
					],
				},
				{
					id: 3,
					name: 'FootyFocus',
					description: 'A football analytics dashboard with live match stats and player insights.',
					techStack: ['Angular', 'Java', 'Docker','PostgreSQL'],
					citeUrl: 'https://footy-focus4.vercel.app',
					repoUrl: 'https://github.com/mekachi015/footyfocus4',
					images: [
						{ src: '/project-screenshots/footyfocus-home-page.png', alt: 'FootyFocus home page' },
						{ src: '/project-screenshots/footyfocus-league-standings.png', alt: 'FootyFocus league standings' },
						{ src: '/project-screenshots/footyfocus-top-goal-scorers.png', alt: 'FootyFocus top goal scorers' },
						{ src: '/project-screenshots/footyfocus-upcoming-fixtures.png', alt: 'FootyFocus upcoming fixtures' },
						{ src: '/project-screenshots/footyfocus-league-champions.png', alt: 'FootyFocus league champions' },
						{ src: '/project-screenshots/footyfocus-player-search.png', alt: 'FootyFocus player search' },
						{ src: '/project-screenshots/footyfocus-player-details.png', alt: 'FootyFocus player details' }

					],
				},
				{
					id: 5,
					name: 'Driver Prep',
					description: 'A web app for K53 driver preparation, providing practice tests and learning resources for driving exams.',
					techStack: ['React', 'Serverless API functions', 'Upstash Redis'],
					citeUrl: 'https://driver-prep-k53.vercel.app',
					repoUrl: 'https://github.com/driver-prep',
					images: [
						{ src: '/project-screenshots/driver-prep-homescreen.png', alt: 'Driver Prep home' },
						{ src: '/project-screenshots/driver-prep-admin-dashboard.png', alt: 'Driver Prep admin dashboard' },
						{ src: '/project-screenshots/driver-prep-admin-dashboard2.png', alt: 'Driver Prep dashboard2' },
						{ src: '/project-screenshots/driver-prep-test screen.png', alt: 'Driver Prep practice test' },
						{ src: '/project-screenshots/driver-prep-test result.png', alt: 'Driver Prep test result' },
						{ src: '/project-screenshots/driver-prep-test-screen2.png', alt: 'Driver Prep learning resources' },
						{ src: '/project-screenshots/driver-prep-error.png', alt: 'Driver Prep learning resources 2' }

					],
				},
				{
					id: 4,
					name: 'Mzansi Plaza',
					description: 'An e-commerce platform designed to promote a circular economy by connecting local sellers and buyers for second-hand goods.',
					techStack: ['Angular', 'Java', 'PostgreSQL', 'Docker'],
					citeUrl: '',
					repoUrl: 'https://github.com/The-DigitalAcademy/eMzanziplaza',
					images: [
						{ src: 'https://placehold.co/600x340/1b4332/ffffff?text=Mzansi+Plaza+Home', alt: 'Mzansi Plaza home' },
						{ src: 'https://placehold.co/600x340/2d6a4f/ffffff?text=Mzansi+Plaza+Listings', alt: 'Mzansi Plaza listings' },
						{ src: 'https://placehold.co/600x340/40916c/ffffff?text=Mzansi+Plaza+Cart', alt: 'Mzansi Plaza cart' },
					],
				},
				
				{
					id: 2,
					name: 'iRenew Store',
					description: 'A web app for second hand electronics, allowing users to buy and sell refurbished devices.',
					techStack: ['Angular', 'Java', 'PostgreSQL'],
					citeUrl: '',
					repoUrl: 'https://github.com/tebohonthako/iRenew-store',
					images: [
						{ src: 'https://placehold.co/600x340/3d0000/ffffff?text=iRenew+Home', alt: 'iRenew Store home' },
						{ src: 'https://placehold.co/600x340/7b0000/ffffff?text=iRenew+Products', alt: 'iRenew Store products' },
						{ src: 'https://placehold.co/600x340/b71c1c/ffffff?text=iRenew+Detail', alt: 'iRenew Store product detail' },
					],
				}
			],
		}
	},
	computed: {
		deployedProjects(): Project[] {
			return (this.projects as Project[]).filter(p => p.citeUrl)
		},
		pendingProjects(): Project[] {
			return (this.projects as Project[]).filter(p => !p.citeUrl)
		},
	},
	mounted() {
		window.addEventListener('keydown', this.handleKey)
	},
	beforeUnmount() {
		window.removeEventListener('keydown', this.handleKey)
	},
	methods: {
		visitSite(project: Project) {
			if (project.citeUrl) {
				window.open(project.citeUrl, '_blank', 'noopener,noreferrer')
			} else {
				this.notLivePopup = true
			}
		},
		openLightbox(project: Project) {
			this.lightbox.project = project
			this.lightbox.index = 0
			this.lightbox.open = true
			document.body.style.overflow = 'hidden'
		},
		closeLightbox() {
			this.lightbox.open = false
			this.lightbox.project = null
			document.body.style.overflow = ''
		},
		lbNext() {
			const total = this.lightbox.project?.images.length ?? 0
			this.lightbox.index = (this.lightbox.index + 1) % total
		},
		lbPrev() {
			const total = this.lightbox.project?.images.length ?? 0
			this.lightbox.index = (this.lightbox.index - 1 + total) % total
		},
		handleKey(e: KeyboardEvent) {
			if (!this.lightbox.open) return
			if (e.key === 'ArrowRight') this.lbNext()
			else if (e.key === 'ArrowLeft') this.lbPrev()
			else if (e.key === 'Escape') this.closeLightbox()
		},
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
	margin-bottom: 0.75rem;
	color: #2c3e50;
}

.section-intro {
	text-align: center;
	color: #6b7280;
	font-size: 1rem;
	line-height: 1.7;
	max-width: 600px;
	margin: 0 auto 3rem;
}

/* ── Section groups ── */
.section-group {
	margin-bottom: 3.5rem;
}

.group-label {
	display: inline-flex;
	align-items: center;
	gap: 0.5rem;
	font-size: 0.8rem;
	font-weight: 700;
	text-transform: uppercase;
	letter-spacing: 0.1em;
	color: #6b7280;
	margin-bottom: 1.25rem;
	padding: 0.35rem 0.9rem;
	border: 1px solid #e5e7eb;
	border-radius: 100px;
	background: #fff;
}

.group-dot {
	width: 8px;
	height: 8px;
	border-radius: 50%;
	flex-shrink: 0;
}

.group-dot--live {
	background: #34d399;
	box-shadow: 0 0 0 3px rgba(52, 211, 153, 0.2);
	animation: pulse-dot 2s ease infinite;
}

.group-dot--pending {
	background: #f59e0b;
}

@keyframes pulse-dot {
	0%, 100% { box-shadow: 0 0 0 0 rgba(52, 211, 153, 0.4); }
	50%       { box-shadow: 0 0 0 5px rgba(52, 211, 153, 0); }
}

.project-card--pending {
	opacity: 0.82;
}

.project-link--muted {
	color: #9ca3af !important;
	cursor: pointer;
}

/* ── Not-live popup ── */
.popup-overlay {
	position: fixed;
	inset: 0;
	background: rgba(0, 0, 0, 0.55);
	z-index: 2000;
	display: flex;
	align-items: center;
	justify-content: center;
	padding: 1rem;
}

.popup {
	background: #fff;
	border-radius: 16px;
	padding: 2rem 2.5rem;
	max-width: 380px;
	width: 100%;
	text-align: center;
	box-shadow: 0 20px 60px rgba(0,0,0,0.2);
}

.popup-icon {
	font-size: 2.5rem;
	margin-bottom: 0.75rem;
}

.popup-title {
	font-size: 1.25rem;
	font-weight: 700;
	color: #2c3e50;
	margin: 0 0 0.5rem;
}

.popup-msg {
	color: #6b7280;
	font-size: 0.95rem;
	line-height: 1.6;
	margin: 0 0 1.5rem;
}

.popup-close-btn {
	background: #2c3e50;
	color: #fff;
	border: none;
	padding: 0.65rem 2rem;
	border-radius: 8px;
	font-size: 0.9rem;
	font-weight: 600;
	cursor: pointer;
	transition: opacity 0.2s;
}
.popup-close-btn:hover { opacity: 0.8; }

.projects-grid {
	display: grid;
	grid-template-columns: repeat(auto-fit, minmax(350px, 1fr));
	gap: 2rem;
}

/* ── Card ── */
.project-card {
	background: white;
	border-radius: 15px;
	overflow: hidden;
	box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
	transition: transform 0.3s, box-shadow 0.3s;
	display: flex;
	flex-direction: column;
}

.project-card:hover {
	transform: translateY(-8px) scale(1.02);
	box-shadow: 0 15px 30px rgba(52, 152, 219, 0.15);
}

/* ── Card body ── */
.project-body {
	padding: 1.5rem;
	display: flex;
	flex-direction: column;
	flex: 1;
	justify-content: space-between;
	gap: 0.75rem;
}

.project-header {
	display: flex;
	justify-content: space-between;
	align-items: flex-start;
	margin-bottom: 0.8rem;
}

.project-title {
	font-size: 1.4rem;
	color: #2c3e50;
	font-weight: 700;
}

.project-links {
	display: flex;
	gap: 1rem;
	flex-shrink: 0;
}

.project-link {
	color: #3498db;
	font-size: 0.9rem;
	text-decoration: none;
	font-weight: 600;
	display: flex;
	align-items: center;
	gap: 4px;
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
	transition: background 0.3s;
}

.tech-tag:hover {
	background: linear-gradient(90deg, #42b883, #3498db);
}

/* ── View Images button ── */
.view-images-btn {
	display: inline-flex;
	align-items: center;
	gap: 0.5rem;
	margin-top: 0.5rem;
	padding: 0.55rem 1.1rem;
	border: 1.5px solid #3498db;
	background: transparent;
	color: #3498db;
	border-radius: 8px;
	font-size: 0.88rem;
	font-weight: 600;
	cursor: pointer;
	transition: background 0.2s, color 0.2s;
	align-self: flex-start;
}

.view-images-btn:hover {
	background: #3498db;
	color: white;
}

.img-count {
	background: #3498db;
	color: white;
	border-radius: 100px;
	padding: 1px 7px;
	font-size: 0.75rem;
	font-weight: 700;
	transition: background 0.2s;
}

.view-images-btn:hover .img-count {
	background: white;
	color: #3498db;
}

/* ── Lightbox Overlay ── */
.lightbox-overlay {
	position: fixed;
	inset: 0;
	background: rgba(0, 0, 0, 0.88);
	z-index: 1000;
	display: flex;
	align-items: center;
	justify-content: center;
	padding: 1rem;
}

.lightbox {
	background: #111;
	border-radius: 16px;
	width: 100%;
	max-width: 900px;
	overflow: hidden;
	display: flex;
	flex-direction: column;
	box-shadow: 0 30px 80px rgba(0,0,0,0.7);
}

.lightbox-header {
	display: flex;
	align-items: center;
	justify-content: space-between;
	padding: 1rem 1.25rem;
	border-bottom: 1px solid rgba(255,255,255,0.08);
}

.lightbox-title {
	color: #fff;
	font-size: 1rem;
	font-weight: 700;
	letter-spacing: 0.02em;
}

.lightbox-close {
	background: rgba(255,255,255,0.08);
	border: none;
	color: #fff;
	width: 34px;
	height: 34px;
	border-radius: 8px;
	display: flex;
	align-items: center;
	justify-content: center;
	cursor: pointer;
	transition: background 0.2s;
}
.lightbox-close:hover { background: rgba(255,255,255,0.18); }

/* ── Lightbox Carousel ── */
.lightbox-carousel {
	position: relative;
	width: 100%;
	aspect-ratio: 16 / 9;
	overflow: hidden;
	background: #000;
}

.lightbox-track {
	display: flex;
	height: 100%;
	transition: transform 0.45s cubic-bezier(0.4, 0, 0.2, 1);
	will-change: transform;
}

.lightbox-slide {
	min-width: 100%;
	height: 100%;
	flex-shrink: 0;
	display: flex;
	align-items: center;
	justify-content: center;
}

.lightbox-img {
	max-width: 100%;
	max-height: 100%;
	object-fit: contain;
	display: block;
	user-select: none;
}

/* Prev / Next */
.lb-btn {
	position: absolute;
	top: 50%;
	transform: translateY(-50%);
	background: rgba(255,255,255,0.12);
	backdrop-filter: blur(6px);
	border: 1px solid rgba(255,255,255,0.2);
	color: #fff;
	width: 44px;
	height: 44px;
	border-radius: 50%;
	display: flex;
	align-items: center;
	justify-content: center;
	cursor: pointer;
	z-index: 2;
	transition: background 0.2s;
}
.lb-btn:hover { background: rgba(255,255,255,0.28); }
.lb-btn--prev { left: 14px; }
.lb-btn--next { right: 14px; }

/* Footer */
.lightbox-footer {
	display: flex;
	align-items: center;
	justify-content: center;
	gap: 1.5rem;
	padding: 0.85rem 1.25rem 0.5rem;
}

.lb-dots {
	display: flex;
	gap: 7px;
}

.lb-dot {
	width: 8px; height: 8px;
	border-radius: 50%;
	border: none;
	background: rgba(255,255,255,0.3);
	cursor: pointer;
	padding: 0;
	transition: background 0.2s, transform 0.2s;
}
.lb-dot--active {
	background: #fff;
	transform: scale(1.4);
}

.lb-counter {
	color: rgba(255,255,255,0.55);
	font-size: 0.8rem;
	font-weight: 600;
	min-width: 40px;
	text-align: center;
}

.lightbox-caption {
	color: rgba(255,255,255,0.45);
	font-size: 0.8rem;
	text-align: center;
	padding: 0.35rem 1.25rem 1rem;
	margin: 0;
}

/* ── Transition ── */
.fade-enter-active, .fade-leave-active { transition: opacity 0.22s ease; }
.fade-enter-from, .fade-leave-to { opacity: 0; }

@media (max-width: 768px) {
	.projects-grid {
		grid-template-columns: 1fr;
	}
	.lightbox { border-radius: 10px; }
}
</style>