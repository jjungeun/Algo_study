import re

def solution(word, pages):
	meta_parser = re.compile('<meta(.+?)/>')
	a_parser = re.compile('<a href="(.+?)">')
	outer_link = {}
	page_infos = []
	for page in pages:
		page_dict = {}
		a_tags = a_parser.findall(page)
		meta_tag = meta_parser.search(page).group().split(' ')[2]
		page_dict['url'] = meta_tag.split('"')[1]
		page_dict['outer_list'] = a_tags
		page_dict['basic_score'] = re.sub('[^a-z]+', '.', page.lower()).split('.').count(word.lower())
		outer_link[page_dict['url']] = page_dict['basic_score']
		page_infos.append(page_dict)

	for page_info in page_infos:
		for outer in page_info['outer_list']:
			if outer in outer_link.keys():
				outer_link[outer] += page_info['basic_score'] / len(page_info['outer_list'])

	max_score = max(outer_link.values())
	for idx in range(len(page_infos)):
		url = page_infos[idx]['url']
		if outer_link[url] == max_score:
			return idx
word = "blind"
pages = ["<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"]
print(solution(word, pages))
