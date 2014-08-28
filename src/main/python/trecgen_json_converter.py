#!/usr/bin/python

import sys
import json

class SetEncoder(json.JSONEncoder):
  def default(self, obj):
    if isinstance(obj, set): return sorted(list(obj))
    return json.JSONEncoder.default(self, obj)

def create_snippet(did, begin, end):
  return {"document": did, "beginSection": "", "endSection": "", 
          "offsetInBeginSection": begin, "offsetInEndSection": end}

qid2gs = {}
for line in open(sys.argv[1]):
  (qid, did, begin, end, aspects) = line.strip().split('\t')
  if qid not in qid2gs:
    qid2gs[qid] = {}
    qid2gs[qid]["id"] = qid
    qid2gs[qid]["documents"] = set()
    qid2gs[qid]["snippets"] = []
    qid2gs[qid]["concepts"] = set()
  qid2gs[qid]["documents"].add(did)
  qid2gs[qid]["snippets"].append(create_snippet(did, begin, end))
  qid2gs[qid]["concepts"].update(aspects.split('|'))

print json.dumps({"questions": qid2gs.values()}, 
                 sort_keys=True, indent=2, cls=SetEncoder)
